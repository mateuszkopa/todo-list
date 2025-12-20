

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TodoRepository todoRepository; 

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getOrCreateCategory(String name) {
        // ... (stara logika bez zmian)
        return categoryRepository.findByName(name)
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(name);
                    return categoryRepository.save(newCategory);
                });
    }

    public boolean deleteCategory(Long id) {
        long taskCount = todoRepository.countByCategory_Id(id);
        if (taskCount > 0) {
            return false; 
        }
        categoryRepository.deleteById(id);
        return true;
    }
}
