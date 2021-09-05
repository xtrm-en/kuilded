import me.xtrm.kuilded.event.Event;
import me.xtrm.kuilded.event.EventHandler;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Test {
    public Map<Class<? extends Event>, List<Consumer<? extends Event>>> eventHandler;

}
