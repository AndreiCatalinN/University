task main()
{
	int i;
	for(i=0;i<4;i++)
	{
     resetMotorEncoder(motorA);
     resetMotorEncoder(motorD);
     setMultipleMotors(40, motorA, motorD);
     sleep(3000);

     setMotor(motorA, 40);
     setMotor(motorD, 0);
     sleep(760);
	}


}
