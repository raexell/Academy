package net.bit.academia.model.net.bit.academia.persistence.repositories.inMemory;


import net.bit.academia.model.Course;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.CourseRepository;

import java.util.Collection;
import java.util.Map;

public class InMemoryRepositoryCorsi implements CourseRepository {
    private DatabaseInMemoria data = DatabaseInMemoria.getInstance();
    @Override
    public Course create(Course toInsert) {
        Map<Integer, Course> corsi = data.getCorsi();
        int maxKey = corsi.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
        toInsert.setId(++maxKey);
        corsi.put(toInsert.getId(),toInsert);
        return toInsert;
    }

    @Override
    public boolean delete(int corsiID) {
        Map<Integer, Course> corsi = data.getCorsi();
        Course x = corsi.remove(corsiID);
        return x != null;
    }

    @Override
    public boolean update(int corsiID, Course toUpdate) {
        Map<Integer, Course> corsi = data.getCorsi();
        Course old= corsi.replace(corsiID,toUpdate);
        return old != null;
    }

    @Override
    public Collection<Course> getAll() {
        Map<Integer, Course> corsi = data.getCorsi();
        return corsi.values();
    }

    @Override
    public Collection<Course> getByLastNameLike(String pattern) {
        return null;
    }

    @Override
    public Course findByID(int id) {
        return data.getCorsi().get(id);
    }
}
