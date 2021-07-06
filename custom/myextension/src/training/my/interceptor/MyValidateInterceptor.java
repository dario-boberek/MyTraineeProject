package training.my.interceptor;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

public class MyValidateInterceptor implements ValidateInterceptor<UserModel> {

    @Override
    public void onValidate(UserModel userModel, InterceptorContext ctx) throws InterceptorException {
        if (userModel.getAge() < 0)
        throw new InterceptorException("Age can't be less than '0'");
    }
}
