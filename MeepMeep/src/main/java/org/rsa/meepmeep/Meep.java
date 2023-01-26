package org.rsa.meepmeep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.MarkerCallback;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class Meep {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        Vector2d vector2d = new Vector2d(0, 0);
        MarkerCallback call = new MarkerCallback() {
            @Override
            public void onMarkerReached() {
            int a= 1;
            }
        };
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                 .setConstraints(65, 60, Math.toRadians(85), Math.toRadians(80), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(38, -52, 90))
                                .splineTo(new Vector2d(0,0), 90)
                                .addSpatialMarker(new Vector2d(0,0), call)
                                .waitSeconds(4)
                                .splineTo(new Vector2d(20, 30), 10)
                                .splineTo(new Vector2d(20, -52), -52)
                                    .build()

                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}