package engtelecom.poo;

import raytracer.ABunchOfSpheres;
import raytracer.Sampler;
import raytracer.Scene;

import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.NumberFormatException;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MakeMovieSequential {

    public MakeMovieSequential(int num_frames) {

        // Create a movie object
        ABunchOfSpheres movie = new ABunchOfSpheres();

        LocalTime in = LocalTime.now();
        System.out.println(in.toString());
        for (int count = 0; count < num_frames; count++) {
            // Render the frames
            movie.render_scene("./frame_" + String.format("%05d", count) + ".png", count);
        }
        in = LocalTime.now();
        System.out.println(in.toString());
    }

    private static void abort(String message) {
        System.err.println(message);
        System.exit(1);
    }

    public static void main(String[] args) {
        int num_frames = 0;
        try {
            num_frames = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            abort("Invalid number of frames (should be an integer)");
        } catch (ArrayIndexOutOfBoundsException e) {
            abort("Usage: java MakeMovieSequential <num of frames>");
        }
        if (num_frames < 0) {
            abort("Invalid number of frames (should be positive)");
        }
        new MakeMovieSequential(num_frames);
    }
}
