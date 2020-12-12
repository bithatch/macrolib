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
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.ptr.PointerByReference;

import uk.co.bithatch.macrolib.wnck.Wnck3Library.GtkContainer;

/**
 * WnckPager:<br>
 * The #WnckPager struct contains only private fields and should not be<br>
 * directly accessed.<br>
 * <i>native declaration : libwnck/pager.h:21</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
@FieldOrder({"parent_instance", "priv"})
public class WnckPager extends Structure {
	
	/**
	 * The Class ByReference.
	 */
	public static class ByReference extends WnckPager implements Structure.ByReference {
		
	}
	
	/**
	 * The Class ByValue.
	 */
	public static class ByValue extends WnckPager implements Structure.ByValue {
		
	}
	
	/**  C type : GtkContainer. */
	public GtkContainer parent_instance;
	
	/**  C type : WnckPagerPrivate*. */
	public PointerByReference priv;
	
	/**
	 * Instantiates a new wnck pager.
	 */
	public WnckPager() {
		super();
	}
	
	/**
	 * Instantiates a new wnck pager.
	 *
	 * @param parent_instance C type : GtkContainer<br>
	 * @param priv C type : WnckPagerPrivate*
	 */
	public WnckPager(GtkContainer parent_instance, PointerByReference priv) {
		super();
		this.parent_instance = parent_instance;
		this.priv = priv;
	};
	
	/**
	 * Instantiates a new wnck pager.
	 *
	 * @param peer the peer
	 */
	public WnckPager(Pointer peer) {
		super(peer);
	};
}
