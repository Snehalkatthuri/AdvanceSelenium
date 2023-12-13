package Practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliExecution {

	public static void main(String[] args) throws Throwable {
		
		Screen scr = new Screen();
		Pattern pattern = new Pattern("C:\\Users\\sneha\\OneDrive\\Desktop\\Qspider training\\Advance Selenium\\Sikuli for desktop app testing\\img1.png");
		scr.click(pattern);
		
		Pattern patt = new Pattern("C:\\Users\\sneha\\OneDrive\\Desktop\\Qspider training\\Advance Selenium\\Sikuli for desktop app testing\\img2.png");
		scr.click(patt);
		scr.type("Excel");
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Pattern pat = new Pattern("C:\\Users\\sneha\\OneDrive\\Desktop\\Qspider training\\Advance Selenium\\Sikuli for desktop app testing\\img3.png");
		scr.click(pat);
		
		Pattern pa = new Pattern("C:\\Users\\sneha\\OneDrive\\Desktop\\Qspider training\\Advance Selenium\\Sikuli for desktop app testing\\img4.png");
		scr.click(pa);
		scr.type("Snehal");
	}

}
