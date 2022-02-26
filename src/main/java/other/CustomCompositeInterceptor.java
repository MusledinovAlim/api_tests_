package other;

import org.slf4j.LoggerFactory;

import veslo.client.inteceptor.CompositeInterceptor;
import veslo.client.inteceptor.LoggingAction;

public class CustomCompositeInterceptor extends CompositeInterceptor {
    public CustomCompositeInterceptor() {
        super(LoggerFactory.getLogger(CustomCompositeInterceptor.class));
        withRequestInterceptActionsChain( LoggingAction.INSTANCE);
        withResponseInterceptActionsChain(LoggingAction.INSTANCE);
    }
}
