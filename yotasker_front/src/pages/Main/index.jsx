import * as React from 'react';
import {
  Typography, Divider, ListItem, ListItemButton,
  ListItemIcon, ListItemText, List, Toolbar, AppBar, CssBaseline, Drawer, Box, Button, Grid, Avatar
} from '@mui/material';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import MailIcon from '@mui/icons-material/Mail';
import instance from '../../axios';
import { useEffect } from 'react';
import { Task } from '../../components/task';
import { TaskList } from '../../components/taskList';
import LogoutIcon from '@mui/icons-material/Logout';

const drawerWidth = 240;

const Main = () => {
  useEffect(() => {
    //instance.get('/users')
  }, [])


  function stringToColor(string) {
    let hash = 0;
    let i;

    /* eslint-disable no-bitwise */
    for (i = 0; i < string.length; i += 1) {
      hash = string.charCodeAt(i) + ((hash << 5) - hash);
    }

    let color = '#';

    for (i = 0; i < 3; i += 1) {
      const value = (hash >> (i * 8)) & 0xff;
      color += `00${value.toString(16)}`.slice(-2);
    }
    /* eslint-enable no-bitwise */

    return color;
  }

  function stringAvatar(name) {
    return {
      sx: {
        bgcolor: stringToColor(name),
      },
      children: `${name.split(' ')[0][0]}${name.split(' ')[1][0]}`,
    };
  }




  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <AppBar
        position="fixed"
        sx={{ width: `calc(100% - ${drawerWidth}px)`, ml: `${drawerWidth}px` }}
      >
        <Toolbar>
          <Grid container spacing={0} align="center" direction="row" alignItems="center" justifyContent="center">
            <Grid xs>
              <Typography variant="h6" noWrap component="div">
                YoTasker
              </Typography>
            </Grid>
            <Grid xs={10}>
              <Typography variant="h5" noWrap component="div">
                Назначенные вам задачи
              </Typography>
            </Grid>
            <Grid xs>
              <Button variant="contained"><LogoutIcon /></Button>
            </Grid>
          </Grid>
        </Toolbar>
      </AppBar>
      <Drawer
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          '& .MuiDrawer-paper': {
            width: drawerWidth,
            boxSizing: 'border-box',
          },
        }}
        variant="permanent"
        anchor="left"
      >
        <Button sx={{ p: 0 }}>
          <Grid container spacing={5} py={1}>
            <Grid item xs={6} md={2}>
              <Avatar {...stringAvatar('Иван Иванов')} />
            </Grid>
            <Grid item xs={6} md={10}>
              <div>Иван Иванов</div>
              <div>ivanich472@gmail.com</div>
            </Grid>
          </Grid>
        </Button>
        <Divider />
        <List>
          {['Назначенные мне', 'Проект 1', 'Проект 2'].map((text, index) => (
            <ListItem key={text} disablePadding>
              <ListItemButton>
                <ListItemIcon>
                  {index === 0 ? <InboxIcon /> : <MailIcon />}
                </ListItemIcon>
                <ListItemText primary={text} />
              </ListItemButton>
            </ListItem>
          ))}
        </List>
      </Drawer>
      <Box
        component="main"
        sx={{ flexGrow: 1, bgcolor: 'background.default', p: 3 }}
      >
        <Toolbar />
        <h2>Новые:</h2>
        <TaskList />
        <h2>В работе:</h2>
        <TaskList />
        <h2>Выполнены: </h2>
        <TaskList />
      </Box>
    </Box>
  );
}
export { Main };