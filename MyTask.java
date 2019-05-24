import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;



public class MyTask extends java.util.TimerTask {
static int col = 30;
static int row = 30;
int cellsize = 20;
int StartX = 40;
int StartY = 40;
private Canvas canvas;
private Frame frame;
static int[][] grid = new int[col][row];
int i;
int j;


public MyTask(Canvas canvas, Frame frame) {
	for (i = 0; i < col; i++) {
	for (j = 0; j < row; j++) {
	grid[i][j] = 0;
}
}
this.canvas = canvas;
this.frame = frame;

//¼àÌýÊó±ê
this.canvas.addMouseListener(new MouseListener() {
public void mouseClicked(MouseEvent click) {
	int mousegx = GetMouseX();
	int mousegy = GetMouseY();
	if (mousegx > -2 && mousegy > -2)
	{
		grid[mousegx][mousegy] = 1 - grid[mousegx][mousegy];
	}
}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
});
}


public void run() {
	Graphics g = this.canvas.getGraphics();
	Render(g);
	if (Main.starter == 1) {
		generate();
}
}


public int GetMouseX() {
	int mousex;
	int mousegx;
	mousex = MouseInfo.getPointerInfo().getLocation().x - this.frame.getX() - this.canvas.getX();
	mousegx = (mousex - StartX) / cellsize + 1;
	return mousegx;
}


public int GetMouseY() {
	int mousey;
	int mousegy;
	mousey = MouseInfo.getPointerInfo().getLocation().y - this.frame.getY() - this.canvas.getY();
	mousegy = (mousey - StartY) / cellsize + 1;
	return mousegy;
}


public void paint(Graphics g) {
	String start;
	String celltype="";
	if(Main.starter==1){
	start = "started";
	}else{
	start= "stoped";
	}
	

	int mousex;
	int mousey;
	int mousegx = GetMouseX();
	int mousegy = GetMouseY();
	g.setColor(new Color(1, 0, 0));
	mousex = MouseInfo.getPointerInfo().getLocation().x - this.frame.getX() - this.canvas.getX();
	mousey = MouseInfo.getPointerInfo().getLocation().y - this.frame.getY() - this.canvas.getY();
	g.drawString("X:" + mousex + " Y:" + mousey, 5, 15);
	g.drawString("gX:" + mousegx + " gY:" + mousegy, 110, 15);
	g.drawString(start + ", Current Cell Type:" + celltype, 200, 15);
}


public void generate() {
int[][] newgrid = new int[col][row];
int x;
int y;
	for (x = 0; x < row; x++) 
	{
		for (y = 0; y < col; y++) 
		{
			newgrid[x][y] = grid[x][y];
		}
	}
	//ÅÐ±ðÁÚ¾Ó
int cellcount;
for (x = 0; x < col; x++)
{
	for (y = 0; y < row; y++) 
	{
		cellcount = 0;
		if (x - 1 >= 0) {
		if (grid[x - 1][y] == 1) 
		{
			cellcount = cellcount + 1;
		}
	}
if (x + 1 < row) {
if (grid[x + 1][y] == 1) 
{
	cellcount = cellcount + 1;
}
}
if (y - 1 >= 0) {
if (grid[x][y - 1] == 1) {
cellcount = cellcount + 1;
}
}
if (y + 1 < col) {
if (grid[x][y + 1] == 1) {
cellcount = cellcount + 1;
}
}
if (y - 1 >= 0 && x - 1 >= 0) {
if (grid[x - 1][y - 1] == 1) {
cellcount = cellcount + 1;
}
}
if (y + 1 < row&& x - 1 >= 0) {
if (grid[x - 1][y + 1] == 1) {
cellcount = cellcount + 1;
}
}
if (y - 1 >= 0 && x + 1 < col) {
if (grid[x + 1][y - 1] == 1) {
cellcount = cellcount + 1;
}
}
if (y + 1 < row && x + 1 < col) {
if (grid[x + 1][y + 1] == 1) {
cellcount = cellcount + 1;
}
}
//end ÁÚ¾Ó

if (Main.celltype == 1) {
if (cellcount == 3) {
	newgrid[x][y] = 1;
} else {
if (cellcount != 3 && cellcount != 2) {
	newgrid[x][y] = 0;
}
}
}
/*if (Main.celltype == 34) {
	if (cellcount == 3 || cellcount == 4) {
		newgrid[x][y] = 1;
	} else {
	if (cellcount != 3 && cellcount != 4) {
		newgrid[x][y] = 0;
	}
	}
}
if (Main.celltype == 3)
{
	if (grid[x][y] == 0)
	{
		if (cellcount > 3 && cellcount < 9) 
		{
			newgrid[x][y] = 1;
		}
	}
if (grid[x][y] == 1) 
	{
		if (cellcount == 1 || cellcount > 5)
		{
			newgrid[x][y] = 0;
		}
	}
}
/*if (Main.celltype == 4) {
if (grid[x][y] == 0) {
if (cellcount == 1) {
newgrid[x][y] = 1;
}
}
if (grid[x][y] == 1) {
if (cellcount != 1) {
newgrid[x][y] = 0;
}
}
}
if (Main.celltype == 5) {
if (grid[x][y] == 0) {
if (cellcount == 3) {
newgrid[x][y] = 1;
}
}
if (grid[x][y] == 1) {
if (cellcount > 6 || cellcount < 1) {
newgrid[x][y] = 0;
}
}
}
if (Main.celltype == 6) {
if (grid[x][y] == 0) {
if (cellcount == 2) {
newgrid[x][y] = 1;
}
}
if (grid[x][y] == 1) {
if (cellcount > 1 || cellcount < 3) {
	newgrid[x][y] = 0;
}
}
}
if (Main.celltype == 7) {
if (grid[x][y] == 0) {
if (cellcount == 3 || cellcount == 5 || cellcount == 7) {
newgrid[x][y] = 1;
}
}
if (grid[x][y] == 1) {
if (cellcount != 3 && cellcount != 1 && cellcount != 5 && cellcount != 8) {
newgrid[x][y] = 0;
}
}
}
if (Main.celltype == 8) {
if (grid[x][y] == 0) {
if (cellcount == 3 || cellcount == 6) {
newgrid[x][y] = 1;
}
}
	if (grid[x][y] == 1)
	{
		if (cellcount != 2 && cellcount != 3) 
		{
			newgrid[x][y] = 0;
		}
	}
}*/
}
}
	for (x = 0; x < row; x++)
	{
		for (y = 0; y < col; y++) 
		{
			grid[x][y] = newgrid[x][y];
		}
	}
}


public void Render(Graphics g) {
	int i = 1;
	int j = 1;
	int mousegx = GetMouseX();
	int mousegy = GetMouseY();
	BufferedImage bi = new BufferedImage(this.canvas.getWidth(), this.canvas.getHeight(),
	BufferedImage.TYPE_INT_ARGB);
	Graphics gbi = bi.getGraphics();
	gbi.setColor(Color.white);
	gbi.fillRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
	paint(gbi);
	for (i = 0; i < row; i++) 
	{
		for (j = 0; j < col; j++)
		{
		if (grid[i][j] == 1) {
			gbi.setColor(new Color(1, 0, 0));
			gbi.fillRect(StartX + (i - 1) * cellsize, StartY + (j - 1) * cellsize, cellsize, cellsize);
		} else {
			gbi.setColor(Color.yellow);
			gbi.drawRect(StartX + (i - 1) * cellsize, StartY + (j - 1) * cellsize, cellsize, cellsize);
		}
		if (i == mousegx && j == mousegy && grid[i][j] == 0) {
		gbi.setColor(new Color(255, 255, 0));
		gbi.fillRect(StartX + (i - 1) * cellsize, StartY + (j - 1) * cellsize, cellsize, cellsize);
		}
	
	
		}
	}
	g.clearRect(0, 0, canvas.getHeight(), canvas.getWidth());
	g.drawImage(bi, 0, 0, null);
}
}

