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
 * <i>native declaration : libwnck/workspace.h:27</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
@FieldOrder({"parent_class", "name_changed", "pad1", "pad2", "pad3", "pad4"})
public class WnckWorkspaceClass extends Structure {
	
	/**
	 * The Class ByReference.
	 */
	public static class ByReference extends WnckWorkspaceClass implements Structure.ByReference {
		
	}
	
	/**
	 * The Class ByValue.
	 */
	public static class ByValue extends WnckWorkspaceClass implements Structure.ByValue {
		
	}
	
	/** <i>native declaration : libwnck/workspace.h</i> */
	public interface name_changed_callback extends Callback {
		
		/**
		 * Apply.
		 *
		 * @param space the space
		 */
		void apply(WnckWorkspace space);
	}
	
	/** <i>native declaration : libwnck/workspace.h</i> */
	public interface pad1_callback extends Callback {
		
		/**
		 * Apply.
		 */
		void apply();
	}
	
	/** <i>native declaration : libwnck/workspace.h</i> */
	public interface pad2_callback extends Callback {
		
		/**
		 * Apply.
		 */
		void apply();
	}
	
	/** <i>native declaration : libwnck/workspace.h</i> */
	public interface pad3_callback extends Callback {
		
		/**
		 * Apply.
		 */
		void apply();
	}
	/** <i>native declaration : libwnck/workspace.h</i> */
	public interface pad4_callback extends Callback {
		
		/**
		 * Apply.
		 */
		void apply();
	};
	/**  C type : name_changed_callback*. */
	public WnckWorkspaceClass.name_changed_callback name_changed;;
	/**  C type : pad1_callback*. */
	public uk.co.bithatch.macrolib.wnck.WnckActionMenuClass.pad1_callback pad1;;
	/**  C type : pad2_callback*. */
	public uk.co.bithatch.macrolib.wnck.WnckActionMenuClass.pad2_callback pad2;;
	/**  C type : pad3_callback*. */
	public uk.co.bithatch.macrolib.wnck.WnckActionMenuClass.pad3_callback pad3;;
	
	/**  C type : pad4_callback*. */
	public uk.co.bithatch.macrolib.wnck.WnckActionMenuClass.pad4_callback pad4;
	
	/**  C type : GObjectClass. */
	public GObjectClass parent_class;
	
	/**
	 * Instantiates a new wnck workspace class.
	 */
	public WnckWorkspaceClass() {
		super();
	}
	
	/**
	 * Instantiates a new wnck workspace class.
	 *
	 * @param parent_class C type : GObjectClass<br>
	 * @param name_changed C type : name_changed_callback*<br>
	 * @param pad1 C type : pad1_callback*<br>
	 * @param pad2 C type : pad2_callback*<br>
	 * @param pad3 C type : pad3_callback*<br>
	 * @param pad4 C type : pad4_callback*
	 */
	public WnckWorkspaceClass(GObjectClass parent_class, WnckWorkspaceClass.name_changed_callback name_changed, uk.co.bithatch.macrolib.wnck.WnckActionMenuClass.pad1_callback pad1, uk.co.bithatch.macrolib.wnck.WnckActionMenuClass.pad2_callback pad2, uk.co.bithatch.macrolib.wnck.WnckActionMenuClass.pad3_callback pad3, uk.co.bithatch.macrolib.wnck.WnckActionMenuClass.pad4_callback pad4) {
		super();
		this.parent_class = parent_class;
		this.name_changed = name_changed;
		this.pad1 = pad1;
		this.pad2 = pad2;
		this.pad3 = pad3;
		this.pad4 = pad4;
	};
	
	/**
	 * Instantiates a new wnck workspace class.
	 *
	 * @param peer the peer
	 */
	public WnckWorkspaceClass(Pointer peer) {
		super(peer);
	};
}
