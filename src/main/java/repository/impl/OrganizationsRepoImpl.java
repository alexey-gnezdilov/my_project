package repository.impl;

import databasesInMemory.OrganizationsDatabase;
import repository.OrganizationsRepo;

import java.util.ArrayList;

public class OrganizationsRepoImpl implements OrganizationsRepo {
    private final OrganizationsDatabase organizationsDatabase;

    public OrganizationsRepoImpl() {
        organizationsDatabase = new OrganizationsDatabase();
    }

    @Override
    public ArrayList<String> getOrganizations() {
        return organizationsDatabase.getOrganizations();
    }
}
