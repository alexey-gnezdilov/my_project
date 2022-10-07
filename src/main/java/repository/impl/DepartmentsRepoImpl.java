package repository.impl;

import databasesInMemory.DepartmentsDatabase;
import repository.DepartmentsRepo;

import java.util.ArrayList;

public class DepartmentsRepoImpl implements DepartmentsRepo {
    private final DepartmentsDatabase departmentsDatabase;

    public DepartmentsRepoImpl() {
        departmentsDatabase = new DepartmentsDatabase();
    }

    @Override
    public ArrayList<String> getDepartments() {
        return departmentsDatabase.getDepartments();
    }
}
