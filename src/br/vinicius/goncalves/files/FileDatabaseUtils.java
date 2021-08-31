package br.vinicius.goncalves.files;

import br.vinicius.goncalves.logincount.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileDatabaseUtils {

    private File file = null;
    private FileConfiguration fileConfiguration = null;

    public void createDatabaseFolder() {
        File newFolder = new File("plugins/gLoginCount/database/");
        if (!newFolder.exists()) {
            if (newFolder.mkdirs()) {

            }
        }
    }

        public void createDatabaseFile () {
            File newFile = new File("plugins/gLoginCount/configuracaoDatabase.yml");
            if (!newFile.exists()) {
                Main.getPlugin(Main.class).saveResource("configuracaoDatabase.yml", false);

            }
        }

        public FileConfiguration getFileConfiguration () {
            if (this.fileConfiguration == null) {
                file = new File("plugins/gLoginCount/configuracaoDatabase.yml");
                this.fileConfiguration = YamlConfiguration.loadConfiguration(this.file);
            }
            return this.fileConfiguration;
        }

        public void saveFile () {
            try {
                getFileConfiguration().save(this.file);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }
