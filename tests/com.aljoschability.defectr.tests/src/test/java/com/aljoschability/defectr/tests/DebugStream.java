package com.aljoschability.defectr.tests;

import java.io.PrintStream;
import java.text.MessageFormat;

public class DebugStream extends PrintStream {
	private static final DebugStream INSTANCE = new DebugStream();
	private static PrintStream normal;

	public static void activate() {
		normal = System.out;
		System.setOut(INSTANCE);
	}

	public static void deactivate() {
		System.setOut(normal);
	}

	private DebugStream() {
		super(System.out);
	}

	@Override
	public void println() {
		showLocation();
		super.println();
	}

	@Override
	public void println(boolean x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(char x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(char[] x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(double x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(float x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(int x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(long x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(Object x) {
		showLocation();
		super.println(x);
	}

	@Override
	public void println(String x) {
		showLocation();
		super.println(x);
	}

	private void showLocation() {
		StackTraceElement caller = Thread.currentThread().getStackTrace()[3];

		String file = caller.getFileName();
		int line = caller.getLineNumber();

		print(MessageFormat.format("({0}:{1, number,#}) ", file, line));
	}
}
