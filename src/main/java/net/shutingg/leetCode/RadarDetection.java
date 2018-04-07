package net.shutingg.leetCode;

/**
 * http://www.lintcode.com/en/problem/radar-detection/
 *
 * There is a bunch of radars on a 2D plane(Radar has x, y coordinates, and a radius r which is the range can be detected). Now, there is a car that passes through the range of y = 0 and y = 1 and cannot be detected by the radar. If the car is detected, return YES, otherwise NO.(You can consider that the car is a line segment of length 1 and goes straight from x = 0 to the right)

 Notice

 The number of radars is n，n <= 1000。
 The radar's coordinate x is a non-negative integer, y is an integer, and r is a positive integer.

 Example
 Given coordinates = [[0,2]], radius = [1], return "NO".

 Explanation:
 There is a radar at (0,2) that can detect a circle with a radius of 1 centered on (0,2) and the car will not be detected.
 Given coordinates = [[0,2],[1,2]], radius = [1,2], return "YES"。

 Explanation:
 There is a radar at (0,2) that can detect a circular area with a radius of 2 with a center of (0,2). Radars at (1,2) can detect (1,2) as Center, circular area with 2 radius. The No. 2 radar can detect the passing of the car.
 */
public class RadarDetection {
    /**
     * @param coordinates: The radars' coordinate
     * @param radius: Detection radius of radars
     * @return: The car was detected or not
     */
    public String radarDetection(Point[] coordinates, int[] radius) {
        if (coordinates == null || radius == null || coordinates.length != radius.length) {
            return "NO";
        }

        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].y >= 1 && coordinates[i].y - radius[i] < 1 ||
                    coordinates[i].y <= 0 && radius[i] + coordinates[i].y > 0 ||
                    coordinates[i].y <= 1 && coordinates[i].y >= 0 && radius[i] > 0) {
                return "YES";
            }
        }

        return "NO";
    }
}
