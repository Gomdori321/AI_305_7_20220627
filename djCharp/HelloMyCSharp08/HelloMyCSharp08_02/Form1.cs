﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace HelloMyCSharp08_02
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Cogmo c = new Cogmo();
            c.sayHello();
            c.MoveDown();
            c.MoveUp();
            c.MoveLeft();
            c.MoveRight();

            c.Attack();

            c.Qkey();
            c.Wkey();
            c.Ekey();
            c.Rkey();


        }
    }
}
