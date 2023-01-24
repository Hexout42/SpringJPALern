package ru.lernup.springjpalern.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lernup.springjpalern.dao.entity.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}