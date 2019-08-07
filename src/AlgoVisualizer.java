import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private static int DELAY = 10;
    private Circle circle;
    private LinkedList<Point> points;// 数据
    private AlgoFrame frame;    // 视图
    private int n;
    private int insideCircle=0;

    public AlgoVisualizer(int sceneWidth, int sceneHeight,int n){
        this.n = n;

        // 初始化数据
        // TODO: 初始化数据
        circle = new Circle(sceneWidth/2,sceneHeight/2,sceneHeight/2);
        points = new LinkedList<Point>();
        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("GetPi", sceneWidth, sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        // TODO: 编写自己的动画逻辑
        for(int i=0;i<n;i++){
            if(i%100 ==0) {
                frame.render(circle, points);
                AlgoVisHelper.pause(DELAY);

                int circleArea = insideCircle;
                int squareArea = points.size();
                double piEstimation = 4 * (double) circleArea / squareArea;
                System.out.println(piEstimation);
            }

            int x = (int)(Math.random()*frame.getCanvasHeight());
            int y = (int)(Math.random()*frame.getCanvasHeight());

            Point p = new Point(x,y);
            points.add(p);
            if(circle.isContain(p)){
                insideCircle++;
            }
        }

    }



    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int n = 10000;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,n);
    }
}
