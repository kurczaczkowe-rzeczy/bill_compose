package pl.kurczaczkowe.bills.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import dagger.hilt.android.AndroidEntryPoint
import pl.gungnir.base.theme.BillsTheme
import pl.gungnir.components.toolbar.ButtonToolbarView
import pl.gungnir.components.toolbar.Toolbar
import pl.kurczaczkowe.bills.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ComposeView>(R.id.toolbar).setContent {
            val toolbarConfig = viewModel.toolbarState.value

            BillsTheme {
                Toolbar(
                    title = {
                        toolbarConfig?.title?.let { header ->
                            Text(
                                text = header,
                                style = MaterialTheme.typography.h3,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colors.onBackground,
                            )
                        }
                    },
                    navigationIcon = {
                        toolbarConfig?.navigationButton?.let { navButton ->
                            ButtonToolbarView(type = navButton)
                        }

                    },
                    actionIcons = {
                        Row {
                            toolbarConfig?.actionButton1?.let { actionButton ->
                                ButtonToolbarView(type = actionButton)
                            }
                            toolbarConfig?.actionButton2?.let { actionButton ->
                                ButtonToolbarView(type = actionButton)
                            }
                        }
                    }
                )
            }
        }
    }
}