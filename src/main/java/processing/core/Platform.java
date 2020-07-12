package processing.core;

/**
 * Utility class containing information about which OS we are running on, as well as which platform specific features
 * are available.
 */
public class Platform {
	private Platform() {
		throw new AssertionError("static class only");
	}

	/**
	 * {@code true} only if methods in {@link ThinkDifferent} can be used
	 * without triggering a {@link NoClassDefFoundError}
	 */
	public static final boolean SUPPORTS_APPLE_EAWT;

	static {
		boolean canLoadEawt = true;
		try {
			//Test for existence of com.apple.eawt.* by causing a reflective classload
			Class.forName("com.apple.eawt.Application");
			Class.forName("com.apple.eawt.QuitHandler");
			Class.forName("com.apple.eawt.QuitResponse");
		} catch (ClassNotFoundException x) {
			canLoadEawt = false;
		}
		SUPPORTS_APPLE_EAWT = canLoadEawt;
	}
}
