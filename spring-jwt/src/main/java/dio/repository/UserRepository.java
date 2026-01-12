package dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dio.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT e FROM User e JOIN FETCH e.roles where e.username = (:username)")
    public User findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);

}
