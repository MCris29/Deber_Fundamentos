
package negocio;

import conexion.clsconexion;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class winparking extends javax.swing.JFrame {

    private Timer timer;
    Connection conect = null;
    clsconexion conection = new clsconexion();
    String lugares;
    int hora,minutos,segundos;
    int tiempoentrada, horasalida,totalhoras;
            float preciohora;
    
    
    DefaultTableModel imprimirbusqueda = new DefaultTableModel();  
    Statement st = null;
    ResultSet rs = null;
  
    int contador ;
    public winparking() {
        
        initComponents();
        vaciarTabla();
        mostrar_datos();
        
        deshabilitaringreso();
        
        msnconexion();
        Horayfecha();
        this.getContentPane().setBackground(Color.white);
        
        lugares = JOptionPane.showInputDialog("Ingrese el numero de parqueaderos ; para iniciar");
        preciohora = Float.parseFloat(JOptionPane.showInputDialog("El valor por hora o fraccion :"));
        
        txtnumeroparq__.setText(lugares);
        txtid__.setVisible(false);
    }
      public void msnconexion(){
        conect = conection.getConnection();    
        JOptionPane.showMessageDialog(null, "CONEXION EXITOSA"," ::: Conexion",JOptionPane.WHEN_IN_FOCUSED_WINDOW); 
        
      }
           public void Horayfecha(){
        Calendar cal = Calendar.getInstance();
        String fecha = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MARCH) + 1) + "/" + cal.get(Calendar.YEAR);
        this.JLB_Fecha1.setText(fecha);
      }
      public class cronometro implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
           
        }
    }
        public void limpiaringreso(){
        txtposicionpar__.setText("");
        txtnumeroplaca__.setText("");
        vaciarTabla();
        mostrar_datos();
    }
        public void limpiarfactura(){
        txttotalpagar__.setText("");
        txtnumerohoras__.setText("");
     }
        public void deshabilitaringreso(){
        btnfacturacion__.setEnabled(false);
        btnguardar__.setEnabled(false);
        }
        
       /* public void guardarmonto(){
      try
                {
                    Connection con = null;
                    clsconexion conect = new clsconexion();
                    con = conect.getConnection();
                    Statement reg = con.createStatement();
                    String ger = "insert into registroganancias (fecha,monto) values (?,?)";
                    PreparedStatement ganancia = con.prepareStatement(ger);
                    
                    ganancia.setString(1, JLB_Fecha1.getText());
                    ganancia.setString(2, txttotalpagar__.getText());  
                
                    
                    int m = ganancia.executeUpdate();
                    
                    if (m > 0)
                    {
                        
                        JOptionPane.showMessageDialog(this, "PROCESO COMPLETO -- IMPRIMIR");
                        
                        vaciarTabla();
                        mostrar_datos();
                       
                    }
                } catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(this, "ERROR EN FACTURACION" + ex.getMessage());
                }
            }
        */
     public void vaciarTabla(){
        DefaultTableModel Modelo = (DefaultTableModel) jtblaparqueadero__.getModel();
        String titulosentabla[] = {"Id","N° Lugar","Estado","Placa","Hora Entrada"};
        Modelo = new DefaultTableModel(null,titulosentabla);
        jtblaparqueadero__.setModel(Modelo);
    }

    public void mostrar_datos(){
        
        try {
            //Connection con1 = null;
            DefaultTableModel basededatos = (DefaultTableModel) jtblaparqueadero__.getModel();
            conect = conection.getConnection();
            String pospark[] = new String[5];
            String sql = "select * from lugaresdeparqueo";
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                pospark[0] = rs.getString("Id");
                pospark[1] = rs.getString("posicion");
                pospark[2] = rs.getString("placa");
                pospark[3] = rs.getString("estado");
                pospark[4] = rs.getString("hora_entrada");
                
                basededatos.addRow(pospark);
            }
            jtblaparqueadero__.setModel(basededatos);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "LOS DATOS DE LA TABLA NO SE PUEDEN VISUALIZAR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jtblaparqueadero__ = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txthorasalida__ = new javax.swing.JTextField();
        txtHora__ = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMinutos1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSegundos1 = new javax.swing.JLabel();
        JLB_Fecha1 = new javax.swing.JLabel();
        txtnumeroparq__ = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtposicionpar__ = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtestadoactualparq__ = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txthoraentrada__ = new javax.swing.JTextField();
        btnguardar__ = new javax.swing.JButton();
        btnfacturacion__ = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtnumerohoras__ = new javax.swing.JTextField();
        txttotalpagar__ = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtnumeroplaca__ = new javax.swing.JTextField();
        btnnuevo__ = new javax.swing.JButton();
        txtid__ = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnucerrar__ = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Servicio = new javax.swing.JMenu();
        Servicio1 = new javax.swing.JMenu();
        Servicio2 = new javax.swing.JMenu();
        mnuregistro__2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        jtblaparqueadero__.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jtblaparqueadero__.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N° Lugar", "Estado", "N° Placa", "Hora Entrada"
            }
        ));
        jtblaparqueadero__.setSelectionBackground(new java.awt.Color(51, 204, 255));
        jtblaparqueadero__.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblaparqueadero__MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtblaparqueadero__);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel1.setText("REGISTRO DE INGRESOS PARQUEADERO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/agencias-de-autos.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(200, 200));

        txthorasalida__.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txthorasalida__.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txthorasalida__.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txthorasalida__.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        txthorasalida__.setEnabled(false);

        txtHora__.setBackground(new java.awt.Color(255, 255, 255));
        txtHora__.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txtHora__.setText("00");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel6.setText(":");

        txtMinutos1.setBackground(new java.awt.Color(255, 255, 255));
        txtMinutos1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txtMinutos1.setText("00");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel7.setText(":");

        txtSegundos1.setBackground(new java.awt.Color(255, 255, 255));
        txtSegundos1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        txtSegundos1.setText("00");

        JLB_Fecha1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        JLB_Fecha1.setText("00/00/00");

        txtnumeroparq__.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtnumeroparq__.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnumeroparq__.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtnumeroparq__.setCaretColor(new java.awt.Color(255, 255, 255));
        txtnumeroparq__.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtnumeroparq__.setEnabled(false);
        txtnumeroparq__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroparq__ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel3.setText("Parqueaderos Libres :");

        jLabel4.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel4.setText("Posicion Parqueadero :");

        txtposicionpar__.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtposicionpar__.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtposicionpar__.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtposicionpar__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtposicionpar__ActionPerformed(evt);
            }
        });
        txtposicionpar__.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtposicionpar__KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtposicionpar__KeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel5.setText("Estado Actual de posicion :");

        txtestadoactualparq__.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtestadoactualparq__.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtestadoactualparq__.setText("OCUPADO");
        txtestadoactualparq__.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtestadoactualparq__.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        txtestadoactualparq__.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel8.setText("Hora Entrada :");

        jLabel10.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel10.setText("Hora Salida :");

        txthoraentrada__.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txthoraentrada__.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txthoraentrada__.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txthoraentrada__.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        txthoraentrada__.setEnabled(false);

        btnguardar__.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnguardar__.setForeground(new java.awt.Color(0, 102, 153));
        btnguardar__.setText("Guardar");
        btnguardar__.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        btnguardar__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar__ActionPerformed(evt);
            }
        });

        btnfacturacion__.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnfacturacion__.setForeground(new java.awt.Color(0, 102, 153));
        btnfacturacion__.setText("Facturar Servicio");
        btnfacturacion__.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        btnfacturacion__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacturacion__ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel11.setText("Numero de Horas :");

        jLabel12.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel12.setText("Total a pagar :");

        txtnumerohoras__.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtnumerohoras__.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnumerohoras__.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtnumerohoras__.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        txtnumerohoras__.setEnabled(false);

        txttotalpagar__.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txttotalpagar__.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttotalpagar__.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txttotalpagar__.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        txttotalpagar__.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel9.setText("Numero de placa  :");

        txtnumeroplaca__.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtnumeroplaca__.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnumeroplaca__.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtnumeroplaca__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumeroplaca__ActionPerformed(evt);
            }
        });
        txtnumeroplaca__.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumeroplaca__KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumeroplaca__KeyTyped(evt);
            }
        });

        btnnuevo__.setBackground(new java.awt.Color(255, 102, 102));
        btnnuevo__.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnnuevo__.setForeground(new java.awt.Color(0, 102, 153));
        btnnuevo__.setText("Nuevo");
        btnnuevo__.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2));
        btnnuevo__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevo__ActionPerformed(evt);
            }
        });

        txtid__.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        txtid__.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtid__.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtid__.setCaretColor(new java.awt.Color(255, 255, 255));
        txtid__.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txtid__.setEnabled(false);
        txtid__.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid__ActionPerformed(evt);
            }
        });

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 2));
        jMenuBar1.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N

        mnucerrar__.setText("Inicio");
        mnucerrar__.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(0, 102, 102));
        jMenuItem1.setText("Cerrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnucerrar__.add(jMenuItem1);

        jMenuBar1.add(mnucerrar__);

        Servicio.setText("_____");
        Servicio.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jMenuBar1.add(Servicio);

        Servicio1.setText("_____");
        Servicio1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jMenuBar1.add(Servicio1);

        Servicio2.setText("Ayuda");
        Servicio2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N

        mnuregistro__2.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        mnuregistro__2.setForeground(new java.awt.Color(0, 102, 102));
        mnuregistro__2.setText("Informacion");
        mnuregistro__2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuregistro__2ActionPerformed(evt);
            }
        });
        Servicio2.add(mnuregistro__2);

        jMenuBar1.add(Servicio2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnnuevo__, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardar__, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155)
                        .addComponent(btnfacturacion__, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid__, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLB_Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtestadoactualparq__, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(40, 40, 40)
                                .addComponent(txtposicionpar__, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnumeroparq__, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(76, 76, 76)
                                .addComponent(txtnumeroplaca__, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttotalpagar__, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txthoraentrada__, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txthorasalida__, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtnumerohoras__, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(txtHora__)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMinutos1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSegundos1)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JLB_Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid__, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txthoraentrada__, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnumeroparq__, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtposicionpar__, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthorasalida__, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtestadoactualparq__, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumerohoras__, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHora__)
                        .addComponent(jLabel6)
                        .addComponent(txtMinutos1)
                        .addComponent(jLabel7)
                        .addComponent(txtSegundos1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotalpagar__, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnumeroplaca__, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(btnfacturacion__, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnguardar__, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnnuevo__, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        GregorianCalendar tiempo = new GregorianCalendar();
            
        hora=tiempo.get(Calendar.HOUR);
        minutos=tiempo.get(Calendar.MINUTE);
        segundos=tiempo.get(Calendar.SECOND);
        txtHora__.setText(String.valueOf(hora+12));
        txtMinutos1.setText(String.valueOf(minutos));
        txtSegundos1.setText(String.valueOf(segundos));
        timer=new Timer(1000,new cronometro());
        timer.start();
       txthoraentrada__.setText(Integer.parseInt(txtHora__.getText())+":"+Integer.parseInt(txtMinutos1.getText())+":"+Integer.parseInt(txtSegundos1.getText()));
       txthorasalida__.setText(Integer.parseInt(txtHora__.getText())+":"+Integer.parseInt(txtMinutos1.getText())+":"+Integer.parseInt(txtSegundos1.getText()));

       
    }//GEN-LAST:event_formWindowOpened

    private void txtnumeroparq__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroparq__ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumeroparq__ActionPerformed

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void jtblaparqueadero__MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblaparqueadero__MouseClicked
         try
        {
            int fila = jtblaparqueadero__.getSelectedRow();
            txtid__.setText(jtblaparqueadero__.getValueAt(fila, 0).toString());
            txtposicionpar__.setText(jtblaparqueadero__.getValueAt(fila, 1).toString());
            txtnumeroplaca__.setText(jtblaparqueadero__.getValueAt(fila, 2).toString());
            txtestadoactualparq__.setText(jtblaparqueadero__.getValueAt(fila, 3).toString());
            txthoraentrada__.setText(jtblaparqueadero__.getValueAt(fila, 4).toString());
            
            
            btnguardar__.setEnabled(false);
            btnfacturacion__.setEnabled(true);
            btnnuevo__.setEnabled(true);
            
            tiempoentrada = Integer.parseInt(txthoraentrada__.getText());
            horasalida = Integer.parseInt(txtHora__.getText());
            txtnumerohoras__.setText(String.valueOf((horasalida)-tiempoentrada));
            totalhoras=Integer.parseInt(txtnumerohoras__.getText());
            txttotalpagar__.setText(String.valueOf((preciohora)* totalhoras));
        } catch (Exception ex)
        {
            System.out.println("ERROR AL SELECCIONAR  : " + ex.getMessage());
        }
         
    }//GEN-LAST:event_jtblaparqueadero__MouseClicked

    private void txtposicionpar__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtposicionpar__ActionPerformed
        txtposicionpar__.transferFocus();
    }//GEN-LAST:event_txtposicionpar__ActionPerformed

    private void btnguardar__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar__ActionPerformed
          int a,b;
        a = Integer.parseInt(txtposicionpar__.getText());
        b = Integer.parseInt(txtnumeroparq__.getText());
        if (a>b){
            JOptionPane.showMessageDialog(this, "POSICION  NO EXISTE", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        if (txtposicionpar__.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR EL NUMERO DE POSICION", "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtposicionpar__.requestFocus();
        }else if (txtnumeroplaca__.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "FALTA INGRESAR NUMERO DE PLACA", "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtnumeroplaca__.requestFocus();
        }
        else
        {
         
            try
            {
                
               
                Connection con = null;
                clsconexion conect1 = new clsconexion();
                con = conect1.getConnection();
                Statement st = con.createStatement();
                String sql = "insert into lugaresdeparqueo (posicion,placa,estado,hora_entrada) values (?,?,?,?)";
                PreparedStatement ubicacion = con.prepareStatement(sql);              
                ubicacion.setString(1, txtposicionpar__.getText());
                ubicacion.setString(3, txtestadoactualparq__.getText());
                ubicacion.setString(2, txtnumeroplaca__.getText());
                ubicacion.setString(4, txtHora__.getText());              
                int n = ubicacion.executeUpdate();
                if (n > 0 )
                {
                    JOptionPane.showMessageDialog(this, "DATOS GUARDADOS ");
                    //guardarmonto();
                    vaciarTabla();
                    mostrar_datos();
                    txtposicionpar__.setText("");
                    btnnuevo__.setEnabled(true);
                    contador++;
                    
                }
            } catch (SQLException | HeadlessException e)
            {
                JOptionPane.showMessageDialog(this, "LOS DATOS NO SE GUARDARON CORRECTAMENTE", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
                    int res = Integer.parseInt(txtnumeroparq__.getText());
                    res = res - contador;
                    txtnumeroparq__.setText(""+res);
        }
    }//GEN-LAST:event_btnguardar__ActionPerformed

    private void txtnumeroplaca__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumeroplaca__ActionPerformed
        txtnumeroplaca__.transferFocus();
    }//GEN-LAST:event_txtnumeroplaca__ActionPerformed

    private void btnnuevo__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevo__ActionPerformed

        txthoraentrada__.setText(Integer.parseInt(txtHora__.getText())+":"+Integer.parseInt(txtMinutos1.getText())+":"+Integer.parseInt(txtSegundos1.getText()));
        btnnuevo__.setEnabled(false);
        btnguardar__.setEnabled(true);
        txtposicionpar__.setText("");
        txtnumeroplaca__.setText("");
        
        
    }//GEN-LAST:event_btnnuevo__ActionPerformed

    private void btnfacturacion__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacturacion__ActionPerformed
         int fila = jtblaparqueadero__.getSelectedRow();
        if (fila == -1)
        {
            JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN REGISTRO", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            int opc = JOptionPane.showConfirmDialog(this, "¿FACTURACION?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION)
            {
                try
                {
                    Connection con = null;
                    clsconexion conect = new clsconexion();
                    con = conect.getConnection();
                    Statement st = con.createStatement();
                    //Statement reg = con.createStatement();
                    String sql = "delete from lugaresdeparqueo where Id = ?";
                    //String ger = "insert into registroganancias (fecha,monto) values (?,?)";
                    //PreparedStatement ganancia = con.prepareStatement(ger);
                    PreparedStatement pst = con.prepareStatement(sql); 
                    
                    //ganancia.setString(1, JLB_Fecha1.getText());
                    //ganancia.setString(2, txttotalpagar__.getText());  
                    
                    pst.setInt(1, Integer.parseInt(txtid__.getText()));
                    
                    //int m = ganancia.executeUpdate();
                    int n = pst.executeUpdate();
                    if (n > 0)
                    {
                        
                        JOptionPane.showMessageDialog(this, "PROCESO COMPLETO -- IMPRIMIR");
                        
                        vaciarTabla();
                        mostrar_datos();
                       
                    }
                } catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(this, "ERROR EN FACTURACION" + ex.getMessage());
                }
            }
        }
        
    }//GEN-LAST:event_btnfacturacion__ActionPerformed

    private void mnuregistro__2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuregistro__2ActionPerformed
        JOptionPane.showMessageDialog(null, "Registro de un parqueadero , permIte verificar los lugares disponibles");
    }//GEN-LAST:event_mnuregistro__2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtposicionpar__KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtposicionpar__KeyPressed
       

        String[] titulos = {"Id","N° Lugar","Estado","Placa","Hora Entrada"};
        String[] registros = new String[5];
        String sql = "SELECT * FROM lugaresdeparqueo WHERE posicion LIKE '%" + txtposicionpar__.getText() + "%'";
        imprimirbusqueda = new DefaultTableModel(null, titulos);
       conect = conection.getConnection();
        try
        {
            st = (Statement) conect.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                registros[0] = rs.getString("Id");
                registros[1] = rs.getString("posicion");
                registros[2] = rs.getString("placa");
                registros[3] = rs.getString("estado");
                registros[4] = rs.getString("hora_entrada");       
                imprimirbusqueda.addRow(registros);
            }
            jtblaparqueadero__.setModel(imprimirbusqueda);
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR LOS DATOS "," ::: ADVERTENCIA",JOptionPane.WHEN_IN_FOCUSED_WINDOW); 
            //System.out.println("ERROR AL BUSCAR LOS DATOS : " + ex.getMessage());
        }
    }//GEN-LAST:event_txtposicionpar__KeyPressed

    private void txtnumeroplaca__KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroplaca__KeyPressed
         String[] titulos = {"Id","N° Lugar","Estado","Placa","Hora Entrada"};
        String[] registros = new String[5];
        String sql = "SELECT * FROM lugaresdeparqueo WHERE placa LIKE '%" + txtnumeroplaca__.getText() + "%'";
        imprimirbusqueda = new DefaultTableModel(null, titulos);
       conect = conection.getConnection();
        try
        {
            st = (Statement) conect.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                registros[0] = rs.getString("Id");
                registros[1] = rs.getString("posicion");
                registros[2] = rs.getString("placa");
                registros[3] = rs.getString("estado");
                registros[4] = rs.getString("hora_entrada");       
                imprimirbusqueda.addRow(registros);
            }
            jtblaparqueadero__.setModel(imprimirbusqueda);
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR LOS DATOS "," ::: ADVERTENCIA",JOptionPane.WHEN_IN_FOCUSED_WINDOW); 
            //System.out.println("ERROR AL BUSCAR LOS DATOS : " + ex.getMessage());
        }
    }//GEN-LAST:event_txtnumeroplaca__KeyPressed

    private void txtposicionpar__KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtposicionpar__KeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtposicionpar__KeyTyped

    private void txtnumeroplaca__KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumeroplaca__KeyTyped
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad = (""+c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
    }//GEN-LAST:event_txtnumeroplaca__KeyTyped

    private void txtid__ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid__ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid__ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLB_Fecha1;
    private javax.swing.JMenu Servicio;
    private javax.swing.JMenu Servicio1;
    private javax.swing.JMenu Servicio2;
    private javax.swing.JButton btnfacturacion__;
    private javax.swing.JButton btnguardar__;
    private javax.swing.JButton btnnuevo__;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtblaparqueadero__;
    private javax.swing.JMenu mnucerrar__;
    private javax.swing.JMenuItem mnuregistro__2;
    private javax.swing.JLabel txtHora__;
    private javax.swing.JLabel txtMinutos1;
    private javax.swing.JLabel txtSegundos1;
    private javax.swing.JTextField txtestadoactualparq__;
    private javax.swing.JTextField txthoraentrada__;
    private javax.swing.JTextField txthorasalida__;
    private javax.swing.JTextField txtid__;
    private javax.swing.JTextField txtnumerohoras__;
    private javax.swing.JTextField txtnumeroparq__;
    private javax.swing.JTextField txtnumeroplaca__;
    private javax.swing.JTextField txtposicionpar__;
    private javax.swing.JTextField txttotalpagar__;
    // End of variables declaration//GEN-END:variables
}
