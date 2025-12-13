package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.TempUser;

@Repository
public interface TempUserRepository extends JpaRepository<TempUser, Long> {
}
