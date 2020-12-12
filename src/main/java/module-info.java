module uk.co.bithatch.macrolib {
	requires transitive com.sshtools.jfreedesktop;
	requires transitive jnativehook;
	requires transitive dbus.java;
	requires transitive com.sun.jna;
	requires transitive uk.co.bithatch.linuxio;
	requires com.google.gson;
	opens uk.co.bithatch.macrolib;
	exports uk.co.bithatch.macrolib;
	exports uk.co.bithatch.macrolib.bamf;
	exports uk.co.bithatch.macrolib.wnck;
}