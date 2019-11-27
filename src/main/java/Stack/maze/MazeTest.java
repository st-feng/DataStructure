package Stack.maze;
import Stack.maze.SolutMaze;
import org.junit.jupiter.api.Test;

public class MazeTest {

@Test
  public void mainTest() {
    String[][] arr = new String[6][5];
    arr[0] = new String[]{"入口","1","0","0","0"};
    arr[1] = new String[]{"1","1","1","1","0"};
    arr[2] = new String[]{"1","0","1","1","0"};
    arr[3] = new String[]{"1","1","0","1","1"};
    arr[4] = new String[]{"0","0","1","0","1"};
    arr[5] = new String[]{"1","1","1","0","出口"};

    try{
      SolutMaze sm = new SolutMaze(arr,"1");
      sm.start();
    }catch (Exception e){
      e.printStackTrace();
    }


  }
}
