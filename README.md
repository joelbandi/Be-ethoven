#Be-ethoven
###This project allows you to wave your hands through the air and generate musical notes accordingly. YOU WILL NEED LEAP MOTION SENSOR FOR THIS PROJECT TO WORK.

#####UPDATE: will convert to a maven project in future for dependence management.

Directions on setting up this project:

1.Plug in your leap motion sensor to the usb port of your computer and place it on your keyboard

2.Go to https://www.leapmotion.com/setup and download the leap motion control panel which will start a deamon process that constantly listens to input signals from the leap motion sensor.

3.On your comman terminal run the commmand ```LeapControlPanel``` while the sensor is connected and you will see a gree blip on your top left screen corner indication the background daemon is running.

4.Open this project in your favourite IDE and add leap motion sdk to your compilation classpath. It is located in the LeapMotionSDK folder. Add the native library(.dll) location to the classpath as well.

5.Add jfugue library to your sdk as well. Visit www.jfugue.org/

6.Run this project.

7.Open Be-ethoven.html for visualizations
