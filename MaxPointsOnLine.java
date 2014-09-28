class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
 
public class MaxPointsOnLine {
    public int maxPoints(Point[] points) {
        if(points.length==1)
            return 1;
        double maxk = 999.0;
        int tmax = 0;
        for(int i=0; i<points.length; i++){
            HashMap<Double,Integer> map = new HashMap<Double,Integer>();
            int same = 1;
            for(int j=i+1; j<points.length; j++){
                if(samePoint(points[i],points[j])){
                    same++;
                    continue;
                }
                double k = points[i].x==points[j].x ? maxk : ((double)(points[j].y-points[i].y))/(points[j].x-points[i].x);
                k += 0.0; //to get avoid of 0.0 and -0.0  They are different
                if(map.containsKey(k))
                    map.put(k, map.get(k)+1);
                else
                    map.put(k, 1);
            }
            int max = 0;
            for (Integer value : map.values())
                max = Math.max(value,max);
            tmax = Math.max(tmax,max+same);
        }
        return tmax;
    }
    public boolean samePoint(Point p1, Point p2){
        return p1.x==p2.x && p1.y==p2.y;
    }
}