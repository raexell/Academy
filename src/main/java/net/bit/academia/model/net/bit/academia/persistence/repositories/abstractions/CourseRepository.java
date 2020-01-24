package net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions;



import net.bit.academia.model.Course;

import java.util.Collection;

public interface CourseRepository {

    Course create(Course toInsert);
    boolean delete(int corsiID);
    boolean update(int corsiID, Course toUpdate);
    Collection<Course> getAll();
    Collection<Course> getByLastNameLike(String pattern);
    Course findByID(int id);
}
