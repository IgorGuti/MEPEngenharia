package com.example.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.fragment.AboutFragment
import com.example.myapplication.ui.repository.MqttService
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout da atividade principal a partir do arquivo XML
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura a barra de ação (ActionBar) com a barra de ferramentas (Toolbar)
        setSupportActionBar(binding.appBarMain.toolbar)

        // Obtém referências para o DrawerLayout e NavigationView
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        // Configura a navegação usando o NavController
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Define as configurações da AppBar, especificando os destinos de menu e o DrawerLayout
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_monitorEletrico, R.id.nav_monitorReservatorio
            ), drawerLayout
        )

        // Configura a ActionBar para trabalhar com a navegação
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Configura o NavigationView para trabalhar com a navegação
        navView.setupWithNavController(navController)

        // Solicita permissão para notificações se necessário
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                startMqttService()
            } else {
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        } else {
            startMqttService()
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            startMqttService()
        } else {
            // A permissão não foi concedida. Informe ao usuário que a permissão é necessária.
        }
    }

    private fun startMqttService() {
        val serviceIntent = Intent(this, MqttService::class.java)
        startService(serviceIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Infla o menu na barra de ação, se estiver presente
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                // Crie uma instância do fragmento AboutFragment
                val aboutFragment = AboutFragment()

                // Use o FragmentManager para substituir o conteúdo principal pelo fragmento AboutFragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main, aboutFragment)
                    .addToBackStack(null) // Adicione à pilha de retorno se desejar
                    .commit()

                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        // Configura a navegação de retorno na ActionBar
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
