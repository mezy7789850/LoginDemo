import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;


public class Main {
static int starter = 0;
static int[][] savegrid = new int[MyTask.row][MyTask.col];
static int celltype = 1;


public static void main(String[] args) {
// 关闭
	Button btnclose = new Button("Close Window");
	btnclose.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Closed");
			System.exit(0);
		}
	});
	//暂停，中止
	Button changer = new Button("Start & Stop");
	changer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		starter = 1 - starter;
	}
	});
	//保存
	Button saver = new Button("Save");
	saver.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			int i;
			int j;
			for (i = 0; i < MyTask.row; i++) 
			{
				for (j = 0; j < MyTask.col; j++) 
				{
					savegrid[i][j] = MyTask.grid[i][j];
				}
			}
		}
	});
	//

	//清屏
	Button clear = new Button("Clear");
	clear.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e)
		{
			int i;
			int j;
			for (i = 0; i < MyTask.row; i++) 
			{
				for (j = 0; j < MyTask.col; j++)
				{
						MyTask.grid[i][j] = 0;
				}
			}
		}
	});
	
Frame f = new Frame();
Canvas c = new Canvas();
f.setLayout(new FlowLayout());
f.setSize(1200, 850);
c.setSize(750, 750);
f.add(c);
f.add(btnclose);
f.add(changer);
f.add(clear);
f.setVisible(true);
Timer timer = new Timer();
timer.schedule(new MyTask(c, f), 10, 900);
}


}