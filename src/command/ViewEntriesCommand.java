package command;

import controller.DiaryManager;

public class ViewEntriesCommand implements Command {
    private DiaryManager manager;

    public ViewEntriesCommand(DiaryManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.viewEntries();
    }
}
