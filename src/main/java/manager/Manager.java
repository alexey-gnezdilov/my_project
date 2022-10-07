package manager;

import controllers.*;
import repository.DepartmentsRepo;
import repository.impl.DepartmentsRepoImpl;
import services.departmentservice.JaxbDepartmentParser;
import services.departmentservice.impl.JaxbDepartmentParserImpl;
import services.docservices.DocumentFactory;
import services.docservices.IsNumeric;
import services.organizationservices.JaxbOrganizationParser;
import services.organizationservices.impl.JaxbOrganizationParserImpl;
import services.personservices.AuthorsReport;
import services.personservices.JaxbAuthorParser;
import services.docservices.impl.DocumentFactoryImpl;
import repository.DocumentsRepo;
import repository.PersonsRepo;
import repository.OrganizationsRepo;
import repository.impl.DocumentsRepoImpl;
import repository.impl.PersonsRepoImpl;
import repository.impl.OrganizationsRepoImpl;
import services.docservices.impl.IsNumericImpl;
import services.personservices.impl.AuthorsReportImpl;
import services.personservices.impl.JaxbAuthorParserImpl;
import utils.impl.DelayImpl;

public class Manager {

    public static final JaxbAuthorParser JAXB_AUTHOR_PARSER;
    public static final JaxbOrganizationParser JAXB_ORGANIZATION_PARSER;
    public static final JaxbDepartmentParser JAXB_DEPARTMENT_PARSER;
    public static final StartUpController START_UP_CONTROLLER;
    public static final CreateController CREATE_CONTROLLER;
    public static final DeleteController DELETE_CONTROLLER;
    public static final EditController EDIT_CONTROLLER;
    public static final FindController FIND_CONTROLLER;
    public static final ShowController SHOW_CONTROLLER;
    public static final DocumentsRepo DOCUMENTS_REPO;
    public static final PersonsRepo PERSONS_REPO;
    public static final OrganizationsRepo ORGANIZATIONS_REPO;
    public static final DepartmentsRepo DEPARTMENTS_REPO;
    public static final DocumentFactory DOCUMENT_FACTORY;
    public static final IsNumeric IS_NUMERIC;
    public static final AuthorsReport AUTHORS_REPORT;
    public static final DelayImpl DELAY;

    static {
        JAXB_AUTHOR_PARSER = new JaxbAuthorParserImpl();
        JAXB_ORGANIZATION_PARSER = new JaxbOrganizationParserImpl();
        JAXB_DEPARTMENT_PARSER = new JaxbDepartmentParserImpl();
        START_UP_CONTROLLER = new StartUpController();
        CREATE_CONTROLLER = new CreateController();
        DELETE_CONTROLLER = new DeleteController();
        EDIT_CONTROLLER = new EditController();
        FIND_CONTROLLER = new FindController();
        SHOW_CONTROLLER = new ShowController();
        DOCUMENTS_REPO = new DocumentsRepoImpl();
        PERSONS_REPO = new PersonsRepoImpl();
        ORGANIZATIONS_REPO = new OrganizationsRepoImpl();
        DEPARTMENTS_REPO = new DepartmentsRepoImpl();
        DOCUMENT_FACTORY = new DocumentFactoryImpl();
        IS_NUMERIC = new IsNumericImpl();
        AUTHORS_REPORT = new AuthorsReportImpl();
        DELAY = new DelayImpl();
    }
}
