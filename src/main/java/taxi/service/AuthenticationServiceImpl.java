package taxi.service;

import java.util.Optional;
import javax.naming.AuthenticationException;
import taxi.dao.DriverDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Optional<Driver> driver = driverDao.findByLogin(login);
        if (driver.isEmpty() || driver.get().getPassword().equals(password)) {
            throw new AuthenticationException("Login or password doesn't correct");
        }
        return driver.get();
    }

}
