using System;
using Gtk;

public partial class MainWindow: Gtk.Window
{
	public MainWindow () : base (Gtk.WindowType.Toplevel)
	{
		Build ();

		buttonSuma.Clicked += delegate {
			int numero1 = int.Parse(entryNumero1.Text);
			int numero2 = int.Parse(entryNumero2.Text);
			int resultado = numero1 + numero2;
			labelResultado.Text = resultado.ToString();
		};
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}
