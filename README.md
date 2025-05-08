Forum system with channels (id, name, description and messages) and messages (id, message and channel_id).

How to use app:
To add channels, write in body (the name and description to be changed to applicable text): "name": "Motorer", "description": "Här diskuterar vi kring motorer"
To add messages, write in body (the message to be changed to applicable text): "message": "The message"

----------------------------------------
TESTING:
Tests includes unit tests of functions in ChannelService class, component test for ChannelController and an integration test.

Functions tested and motivation why:
- AddChannels  (tested since it is the beginning of the process to add a channel)
- GetAllChannels  (tested since it is important that all channels are included in the get all channel return)
- UpdateChannel (tested with a channel not found in the database at testing (since it is mocked and not added), should return null and not do any update)
- numberOverTen (only tested and created this function to have possibility to show testing of if and edge case)
- CreateChannel in controller (since it is the beginning of the process to create a new channel)
- Add and delete channel in controller (since they act together (a channel needs to be created to be able to be deleted) they are tested together)
- Integrationtest to test both create channel and show all created channels (to see that they work together. Uses test database to isolate it from production database)

How to run the tests: Nothing special needed. 