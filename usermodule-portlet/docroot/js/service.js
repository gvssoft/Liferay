Liferay.Service.register("Liferay.Service.usermodule", "com.usermodule.service", "usermodule-portlet");

Liferay.Service.registerClass(
	Liferay.Service.usermodule, "Useraction",
	{
		create: true
	}
);