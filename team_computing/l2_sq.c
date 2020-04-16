

task main()
{
	int i;
	for(i=0;i<4;i++)
	{
     resetMotorEncoder(motorA);
     resetMotorEncoder(motorD);
     setMultipleMotors(50, motorA, motorD);
     sleep(3000);

     setMotor(motorA, 50);
     setMotor(motorD, 0);
     sleep(676);
	}


}
