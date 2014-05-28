import play.GlobalSettings;
import play.Logger;
import securesocial.core.RuntimeEnvironment;
import service.MyEnvironment;

public class Global extends GlobalSettings {
    private final RuntimeEnvironment env = new MyEnvironment();

    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
        Logger.debug("creating controller: " + controllerClass.getName());
        try {
            return controllerClass.getDeclaredConstructor(RuntimeEnvironment.class).newInstance(env);
        } catch (NoSuchMethodException e) {
            // the controller does not receive a RuntimeEnvironment, delegate creation to base class.
            return super.getControllerInstance(controllerClass);
        }
    }
}