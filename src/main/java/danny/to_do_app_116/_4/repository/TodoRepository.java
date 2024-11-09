package danny.to_do_app_116._4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import danny.to_do_app_116._4.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
