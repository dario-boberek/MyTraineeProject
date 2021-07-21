package training.my.listener;

import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import org.apache.log4j.Logger;

public class MyEventListener extends AbstractEventListener<MyEvent> {
    private static final Logger LOG = Logger.getLogger(MyEventListener.class.getName());

    @Override
    protected void onEvent(MyEvent event) {
        LOG.info("My LOG works, I'm so happy )");
    }
}