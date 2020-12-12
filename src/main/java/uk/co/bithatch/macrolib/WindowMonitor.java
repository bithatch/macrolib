/**
 * Java Window Monitor
 * Copyright © 2020 Bithatch (tanktarta@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package uk.co.bithatch.macrolib;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.freedesktop.dbus.connections.impl.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;

import com.sun.jna.NativeLong;
import com.sun.jna.ptr.PointerByReference;

import uk.co.bithatch.macrolib.bamf.Matcher;
import uk.co.bithatch.macrolib.wnck.GDK;
import uk.co.bithatch.macrolib.wnck.Wnck3Library;
import uk.co.bithatch.macrolib.wnck.WnckApplication;
import uk.co.bithatch.macrolib.wnck.WnckScreen;
import uk.co.bithatch.macrolib.wnck.WnckWindow;


/**
 * The Class WindowMonitor.
 */
public class WindowMonitor implements Closeable {

	/**
	 * The Interface Listener.
	 */
	public interface Listener {
		
		/**
		 * Active changed.
		 *
		 * @param oldApp the old app
		 * @param newApp the new app
		 */
		default void activeChanged(Application oldApp, Application newApp) {
		}

		/**
		 * Active changed.
		 *
		 * @param oldWindow the old window
		 * @param newApp the new app
		 */
		default void activeChanged(Window oldWindow, Window newApp) {
		}

		/**
		 * View closed.
		 *
		 * @param view the view
		 */
		default void viewClosed(View view) {
		}

		/**
		 * View opened.
		 *
		 * @param view the view
		 */
		default void viewOpened(View view) {
		}
	}

	class BAMFAppImpl extends BAMFView implements Application {

		public BAMFAppImpl(uk.co.bithatch.macrolib.bamf.View view) {
			super(view);
		}
	}
	class BAMFView implements View {

		private uk.co.bithatch.macrolib.bamf.View view;

		public BAMFView(uk.co.bithatch.macrolib.bamf.View view) {
			this.view = view;
		}

		@Override
		public String getIcon() {
			return view.Icon();
		}

		@Override
		public String getId() {
			return view.getObjectPath();
		}

		@Override
		public String getName() {
			return view.Name();
		}

		@Override
		public String toString() {
			return "BAMFView [getName()=" + getName() + ", getId()=" + getId() + ", getIcon()=" + getIcon() + "]";
		}

	}
	class BAMFWindowImpl extends BAMFView implements Window {

		public BAMFWindowImpl(uk.co.bithatch.macrolib.bamf.View view) {
			super(view);
		}
	}
	class WnckApplicationImpl implements Application {

		private NativeLong xwindow;

		public WnckApplicationImpl(NativeLong xwindow) {
			this.xwindow = xwindow;
		}

		@Override
		public String getIcon() {
			WnckApplication application = wnck3.wnck_application_get(xwindow);
			wnck3.wnck_screen_force_update(screen);
			return wnck3.wnck_application_get_icon_name(application);
		}

		@Override
		public String getId() {
			WnckApplication application = wnck3.wnck_application_get(xwindow);
			wnck3.wnck_screen_force_update(screen);
			return wnck3.wnck_application_get_name(application);
		}

		@Override
		public String getName() {
			WnckApplication application = wnck3.wnck_application_get(xwindow);
			wnck3.wnck_screen_force_update(screen);
			return wnck3.wnck_application_get_name(application);
		}

		@Override
		public String toString() {
			return "WnckApplicationImpl [getName()=" + getName() + ", getId()=" + getId() + ", getIcon()=" + getIcon()
					+ "]";
		}
	}
	class WnckWindowImpl implements Window {

		private NativeLong xwindow;

		public WnckWindowImpl(NativeLong xwindow) {
			this.xwindow = xwindow;
		}

		@Override
		public String getIcon() {
			WnckWindow window = wnck3.wnck_window_get(xwindow);
			wnck3.wnck_screen_force_update(screen);
			return wnck3.wnck_window_get_icon_name(window);
		}

		@Override
		public String getId() {
			WnckWindow window = wnck3.wnck_window_get(xwindow);
			wnck3.wnck_screen_force_update(screen);
			return wnck3.wnck_window_get_name(window);
		}

		@Override
		public String getName() {
			WnckWindow window = wnck3.wnck_window_get(xwindow);
			wnck3.wnck_screen_force_update(screen);
			return wnck3.wnck_window_get_name(window);
		}

		@Override
		public String toString() {
			return "WnckWindowImpl [getName()=" + getName() + ", getId()=" + getId() + ", getIcon()=" + getIcon() + "]";
		}
	}
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		WindowMonitor m = new WindowMonitor();
		m.addListener(new Listener() {

			@Override
			public void activeChanged(Application oldApp, Application newApp) {
				System.out.println("AAC O: " + (oldApp == null ? "none" : oldApp.getName()) + " N "
						+ (newApp == null ? "none" : newApp.getName()));
			}

			@Override
			public void activeChanged(Window oldWindow, Window newWindow) {
				System.out.println("AWC O: " + (oldWindow == null ? "none" : oldWindow.getName()) + " N "
						+ (newWindow == null ? "none" : newWindow.getName()));
			}

			@Override
			public void viewClosed(View view) {
				System.out.println("VC P: " + view.getName() + " / " + view.getIcon() + " / " + view.getId());
			}

			@Override
			public void viewOpened(View view) {
				System.out.println("VO P: " + view.getName() + " / " + view.getIcon() + " / " + view.getId());
			}

		});
		System.out.println("AW: " + m.getActiveWindow());
		for (Window w : m.getWindows())
			System.out.println("    " + w);
//		System.out.println("AA: " + m.getActiveApplication());
//		for (Application a : m.getApplications())
//			System.out.println("    " + a);
		Thread.sleep(1000000);
	}
	private DBusConnection conn;

	private List<Listener> listeners = Collections.synchronizedList(new ArrayList<>());

	private Matcher matcher;

	private boolean ownQueue;

	private ScheduledExecutorService queue;

	private WnckScreen screen;

	private Wnck3Library wnck3;

	/**
	 * Instantiates a new window monitor.
	 */
	public WindowMonitor() {
		this(Executors.newScheduledThreadPool(1));
		ownQueue = true;
	}

	/**
	 * Instantiates a new window monitor.
	 *
	 * @param queue the queue
	 */
	public WindowMonitor(ScheduledExecutorService queue) {
		this.queue  = queue;
		
		/**
		 * Try BAMF first
		 */
		try {
			if ("false".equals(System.getProperty("jwindowmonitor.bamf", "true")))
				throw new DBusException();

			conn = DBusConnection.getConnection(DBusConnection.DBusBusType.SESSION);
			matcher = conn.getRemoteObject("org.ayatana.bamf", "/org/ayatana/bamf/matcher", Matcher.class);
			conn.addSigHandler(Matcher.ActiveWindowChanged.class, matcher, (sig) -> {
				queue.execute(() -> fireActiveChanged(getBAMFWindow(sig.getOldWin()), getBAMFWindow(sig.getNewWin())));
			});
			conn.addSigHandler(Matcher.ActiveApplicationChanged.class, matcher, (sig) -> {
				queue.execute(() -> fireActiveChanged(getBAMFApplication(sig.getOldApp()),
						getBAMFApplication(sig.getNewApp())));
			});
			conn.addSigHandler(Matcher.ViewOpened.class, matcher, (sig) -> {
				queue.execute(() -> fireViewOpened(getBAMFView(sig.getPath())));
			});
			conn.addSigHandler(Matcher.ViewClosed.class, matcher, (sig) -> {
				queue.execute(() -> fireViewClosed(getBAMFView(sig.getPath())));
			});

		} catch (DBusException dbe) {
			/* Failed, try WNCK bindings and polling */
			dbe.printStackTrace();
			GDK gdk = GDK.INSTANCE;
			gdk.gdk_init(0, new String[0]);
			wnck3 = Wnck3Library.INSTANCE;
			screen = wnck3.wnck_screen_get_default();
			if (screen == null)
				throw new UnsupportedOperationException(
						"No backend found. Please make sure bamf or libwnck is installed.");
//			queue.scheduleAtFixedRate(() -> pollWnck(), 1, 1, TimeUnit.SECONDS);
		}
	}

	/**
	 * Adds the listener.
	 *
	 * @param listener the listener
	 */
	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	/**
	 * Close.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public void close() throws IOException {
		if (conn != null) {
			conn.close();
		}
		if(ownQueue)
			queue.shutdown();
	}

	/**
	 * Gets the active application.
	 *
	 * @return the active application
	 */
	public Application getActiveApplication() {
		if (matcher == null) {
			throw new UnsupportedOperationException();
		} else {
			return getBAMFApplication(matcher.ActiveApplication());
		}
	}

	/**
	 * Gets the active window.
	 *
	 * @return the active window
	 */
	public Window getActiveWindow() {
		if (matcher == null) {
			wnck3.wnck_screen_force_update(screen);
			return getWNCKWindow(wnck3.wnck_screen_get_active_window(screen));
		} else {
			return getBAMFWindow(matcher.ActiveWindow());
		}
	}

	/**
	 * Gets the applications.
	 *
	 * @return the applications
	 */
	public List<Application> getApplications() {
		if (matcher == null) {
			PointerByReference windows = wnck3.wnck_screen_get_windows(screen);
			WnckWindow wnckWindow = new WnckWindow(windows.getPointer());
			WnckApplication wnckApp = wnck3.wnck_window_get_application(wnckWindow);
			return Arrays.asList(getWNCKApplication(wnckApp));
		} else {
			List<Application> l = new ArrayList<>();
			for (String s : matcher.ApplicationPaths()) {
				l.add(getBAMFApplication(s));
			}
			return l;
		}
	}

	/**
	 * Gets the windows.
	 *
	 * @return the windows
	 */
	public List<Window> getWindows() {
		List<Window> wl = new ArrayList<>();
		if (matcher == null) {
			wnck3.wnck_screen_force_update(screen);
			PointerByReference windows = wnck3.wnck_screen_get_windows(screen);
			try {
				// Hrm... how the hell...
//				GList l = new GList(windows.getValue());
//				while(true) {
//					WnckWindow wnckWindow = new WnckWindow(l.data);
//					wl.add(getWNCKWindow(wnckWindow));
//					l = GList.newInstance(null)
//				}
//				
//				for(l; l.next != null ; l = new GList(l.next)) {
//				}
			} finally {
				GDK.INSTANCE.g_list_free(windows);
			}
		} else {
			for (String s : matcher.WindowPaths()) {
				wl.add(getBAMFWindow(s));
			}
		}
		return wl;
	}

	/**
	 * Removes the listener.
	 *
	 * @param listener the listener
	 */
	public void removeListener(Listener listener) {
		listeners.remove(listener);
	}

	protected void fireActiveChanged(Application oldApp, Application newApp) {
		synchronized (listeners) {
			for (int i = listeners.size() - 1; i >= 0; i--)
				listeners.get(i).activeChanged(oldApp, newApp);
		}
	}

	protected void fireActiveChanged(Window oldWindow, Window newWindow) {
		synchronized (listeners) {
			for (int i = listeners.size() - 1; i >= 0; i--)
				listeners.get(i).activeChanged(oldWindow, newWindow);
		}
	}

	protected void fireViewClosed(View view) {
		synchronized (listeners) {
			for (int i = listeners.size() - 1; i >= 0; i--)
				listeners.get(i).viewClosed(view);
		}
	}

	protected void fireViewOpened(View view) {
		synchronized (listeners) {
			for (int i = listeners.size() - 1; i >= 0; i--)
				listeners.get(i).viewOpened(view);
		}
	}

	Application getBAMFApplication(String path) {
		if (conn == null)
			throw new UnsupportedOperationException();
		if (path == null || path.equals(""))
			return null;
		try {
			return new BAMFAppImpl(conn.getRemoteObject("org.ayatana.bamf", path, uk.co.bithatch.macrolib.bamf.View.class));
		} catch (DBusException e) {
			e.printStackTrace();
			throw new IllegalStateException("Failed to get window.", e);
		}
	}

	View getBAMFView(String path) {
		if (conn == null)
			throw new UnsupportedOperationException();
		if (path == null || path.equals(""))
			return null;
		try {
			return new BAMFView(conn.getRemoteObject("org.ayatana.bamf", path, uk.co.bithatch.macrolib.bamf.View.class));
		} catch (DBusException e) {
			e.printStackTrace();
			throw new IllegalStateException("Failed to get window.", e);
		}
	}

	Window getBAMFWindow(String path) {
		if (conn == null)
			throw new UnsupportedOperationException();
		if (path == null || path.equals(""))
			return null;
		try {
			return new BAMFWindowImpl(conn.getRemoteObject("org.ayatana.bamf", path, uk.co.bithatch.macrolib.bamf.View.class));
		} catch (DBusException e) {
			e.printStackTrace();
			throw new IllegalStateException("Failed to get window.", e);
		}
	}

	Application getWNCKApplication(WnckApplication app) {
		if (screen == null)
			throw new UnsupportedOperationException();
		if (app == null)
			return null;
		return new WnckApplicationImpl(wnck3.wnck_application_get_xid(app));
	}

	Window getWNCKWindow(WnckWindow window) {
		if (screen == null)
			throw new UnsupportedOperationException();
		if (window == null)
			return null;
		return new WnckWindowImpl(wnck3.wnck_window_get_xid(window));
	}

	private void pollWnck() {
//		wnck3.wnck_screen_force_update(screen);
		WnckWindow window = wnck3.wnck_screen_get_active_window(screen);
		System.out.println("wn : " + wnck3.wnck_window_get_name(window));
	}
}
