﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace HelloMyCSharp08_01
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            List<Product> products = new List<Product>();
            products.Add(new Product() { id = 1, price = 1000, name = "감자" });
            products.Add(new Product() { id = 3, price = 500, name = "파" });
            products.Add(new Product() { id = 2, price = 100, name = "젤리" });

            //var 대신 다른 거 적어도 됨. 타입을 알면, 타입을 적어줘도 됨
            foreach(Product p in products)
            {
                MessageBox.Show($"{p.name}");
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            List<Product> products = new List<Product>();
            products.Add(new Product() { id = 1, price = 1000, name = "감자" });
            products.Add(new Product() { id = 3, price = 500, name = "파" });
            products.Add(new Product() { id = 2, price = 100, name = "젤리" });

            //CompareTo가 정의되어 있지 않다면
            //products는 정렬이 안 된다.
            //CompareTo가 정의되어 있으니
            //Sort에서는 내부적으로 CompareTo를 호출
            //이걸 이용해서 정렬이 됨.
            //여기선 상품 가격순 정렬 감자 파 젤리 아니고
            //젤리 파 감자 순으로 출력된다.
            products.Sort();

            //var 대신 다른 거 적어도 됨. 타입을 알면, 타입을 적어줘도 됨
            foreach (Product p in products)
            {
                MessageBox.Show($"{p.name}");
            }

        }
    }
}