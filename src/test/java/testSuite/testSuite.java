package testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.CheckBoxes;
import tests.ContextMenu;
import tests.DragAndDrop;
import tests.DropDown;
import tests.DynamicContent;
import tests.DynamicControls;
import tests.DynamicLoading;
import tests.FIleDownload;
import tests.FloatingMenu;
import tests.HoverOver;
import tests.JSExecuter;
import tests.LoginTest;
import tests.NotificationMessage;
import tests.OpenInANewTab;


@RunWith(Suite.class)
@Suite.SuiteClasses({
		LoginTest.class,
		CheckBoxes.class,
		ContextMenu.class,
		DragAndDrop.class,
		DropDown.class,
		DynamicContent.class,
		DynamicControls.class,
		DynamicLoading.class,
		FIleDownload.class,
		FloatingMenu.class,
		HoverOver.class,
		JSExecuter.class,
		OpenInANewTab.class,
		NotificationMessage.class,
		
		
		
})

public class testSuite {

}
