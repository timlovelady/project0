public class EmployeeDAOFactory {
    private static EmployeeDAO employeeDao;

    private EmployeeDAOFactory(){}

    public static EmployeeDAO getEmployeeDaoDao(){
        if(employeeDao==null)
            employeeDao = new EmployeeDAOImplementation();
        return employeeDao;
    }
}
