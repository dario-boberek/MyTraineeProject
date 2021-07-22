package training.my.service;

import de.hybris.platform.core.model.user.UserModel;

import java.util.List;

public interface MyUserService {
    List<UserModel> getUserWithMostOrders();
    int getCurrentNumberOfUsers();
}
