/**
 * Java WNCK bindings
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
package uk.co.bithatch.macrolib.wnck;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

import uk.co.bithatch.macrolib.wnck.Wnck3Library.GObjectClass;

/**
 * <i>native declaration : libwnck/window.h:245</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
@FieldOrder({"parent_class", "name_changed", "state_changed", "workspace_changed", "icon_changed", "actions_changed", "geometry_changed", "class_changed", "role_changed", "type_changed", "pad1"})
public class WnckWindowClass extends Structure {
	
	/** <i>native declaration : libwnck/window.h</i> */
	public interface actions_changed_callback extends Callback {
		
		/**
		 * Apply.
		 *
		 * @param window the window
		 * @param changed_mask the changed mask
		 * @param new_actions the new actions
		 */
		void apply(WnckWindow window, int changed_mask, int new_actions);
	}
	
	/**
	 * The Class ByReference.
	 */
	public static class ByReference extends WnckWindowClass implements Structure.ByReference {
		
	}
	
	/**
	 * The Class ByValue.
	 */
	public static class ByValue extends WnckWindowClass implements Structure.ByValue {
		
	}
	
	/** <i>native declaration : libwnck/window.h</i> */
	public interface class_changed_callback extends Callback {
		
		/**
		 * Apply.
		 *
		 * @param window the window
		 */
		void apply(WnckWindow window);
	}
	
	/** <i>native declaration : libwnck/window.h</i> */
	public interface geometry_changed_callback extends Callback {
		
		/**
		 * Apply.
		 *
		 * @param window the window
		 */
		void apply(WnckWindow window);
	}
	
	/** <i>native declaration : libwnck/window.h</i> */
	public interface icon_changed_callback extends Callback {
		
		/**
		 * Apply.
		 *
		 * @param window the window
		 */
		void apply(WnckWindow window);
	}
	
	/** <i>native declaration : libwnck/window.h</i> */
	public interface name_changed_callback extends Callback {
		
		/**
		 * Apply.
		 *
		 * @param window the window
		 */
		void apply(WnckWindow window);
	}
	
	/** <i>native declaration : libwnck/window.h</i> */
	public interface pad1_callback extends Callback {
		
		/**
		 * Apply.
		 */
		void apply();
	}
	
	/** <i>native declaration : libwnck/window.h</i> */
	public interface role_changed_callback extends Callback {
		
		/**
		 * Apply.
		 *
		 * @param window the window
		 */
		void apply(WnckWindow window);
	}
	
	/** <i>native declaration : libwnck/window.h</i> */
	public interface state_changed_callback extends Callback {
		
		/**
		 * Apply.
		 *
		 * @param window the window
		 * @param changed_mask the changed mask
		 * @param new_state the new state
		 */
		void apply(WnckWindow window, int changed_mask, int new_state);
	}
	
	/** <i>native declaration : libwnck/window.h</i> */
	public interface type_changed_callback extends Callback {
		
		/**
		 * Apply.
		 *
		 * @param window the window
		 */
		void apply(WnckWindow window);
	}
	/** <i>native declaration : libwnck/window.h</i> */
	public interface workspace_changed_callback extends Callback {
		
		/**
		 * Apply.
		 *
		 * @param window the window
		 */
		void apply(WnckWindow window);
	};
	/**  C type : actions_changed_callback*. */
	public uk.co.bithatch.macrolib.wnck.Wnck3Library.actions_changed_callback actions_changed;;
	/**  C type : class_changed_callback*. */
	public WnckWindowClass.class_changed_callback class_changed;;
	/**  C type : geometry_changed_callback*. */
	public WnckWindowClass.geometry_changed_callback geometry_changed;;
	/**  C type : icon_changed_callback*. */
	public uk.co.bithatch.macrolib.wnck.WnckClassGroupClass.icon_changed_callback icon_changed;;
	/**  C type : name_changed_callback*. */
	public uk.co.bithatch.macrolib.wnck.WnckWorkspaceClass.name_changed_callback name_changed;;
	/**  C type : pad1_callback*. */
	public uk.co.bithatch.macrolib.wnck.WnckActionMenuClass.pad1_callback pad1;;
	/**  C type : GObjectClass. */
	public GObjectClass parent_class;;
	/**  C type : role_changed_callback*. */
	public WnckWindowClass.role_changed_callback role_changed;;
	/**  C type : state_changed_callback*. */
	public uk.co.bithatch.macrolib.wnck.Wnck3Library.state_changed_callback state_changed;;
	
	/**  C type : type_changed_callback*. */
	public WnckWindowClass.type_changed_callback type_changed;
	
	/**  C type : workspace_changed_callback*. */
	public WnckWindowClass.workspace_changed_callback workspace_changed;
	
	/**
	 * Instantiates a new wnck window class.
	 */
	public WnckWindowClass() {
		super();
	};
	
	/**
	 * Instantiates a new wnck window class.
	 *
	 * @param peer the peer
	 */
	public WnckWindowClass(Pointer peer) {
		super(peer);
	};
}
