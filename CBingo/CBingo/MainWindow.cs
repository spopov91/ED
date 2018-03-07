using System;
using Gtk;
using Gdk;
using System.Collections.Generic;
public partial class MainWindow: Gtk.Window
{
	private static Color COLOR_GREEN=new Color(0,255,0);

	public MainWindow () : base (Gtk.WindowType.Toplevel)
	{
		Build ();

		List<Button> buttons = new List<Button> ();

		Table table = new Table (9,10,true);
		for (int i = 0; i < 90; i++) {
			Button button = new Button ();
			button.Label = (i + 1).ToString ();
			button.Visible = true;
			uint row = (uint)(i / 10);
			uint column = (uint)(i % 10);
			table.Attach (button, column, column + 1, row, row + 1);
			buttons.Add (button);

		}
		table.Visible = true;
		vbox2.Add (table);
		List<int> bolas = new List<int> ();
		for (int bola = 1; bola <= 90; bola++)
			bolas.Add (bola);

		//buttonAdelante.ModifyBg (StateType.Normal, COLOR_GREEN);
		Random random=new Random();
		buttonAdelante.Clicked += delegate {
			int iAleatorio = random.Next(bolas.Count);
			int bola=bolas[iAleatorio];
			bolas.Remove(bola);
			int i = bola - 1;
			buttons[i].ModifyBg(StateType.Normal, COLOR_GREEN);
		};
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}
