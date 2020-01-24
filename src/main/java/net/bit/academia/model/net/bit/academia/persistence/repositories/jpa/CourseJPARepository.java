package net.bit.academia.model.net.bit.academia.persistence.repositories.jpa;

import net.bit.academia.model.Course;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.CourseRepository;

import java.util.Collection;

public class CourseJPARepository implements CourseRepository {
    @Override
    public Course create(Course toInsert) {
        return null;
    }

    @Override
    public boolean delete(int corsiID) {
        return false;
    }

    @Override
    public boolean update(int corsiID, Course toUpdate) {
        return false;
    }

    @Override
    public Collection<Course> getAll() {
        return null;
    }

    @Override
    public Collection<Course> getByLastNameLike(String pattern) {
        return null;
    }

    @Override
    public Course findByID(int id) {
        return null;
    }
}
