package demo.crepository ; 

import demo.dmodel.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("myUserRepo")
public interface UserRepositoryInterface extends JpaRepository<User, Long> {
	

}